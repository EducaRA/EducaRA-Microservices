<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Models\Disciplina;
use App\Models\Aula;
use Validator;
use Illuminate\Http\Response;
use App\Http\Resources\AulaResource;

class AulaController extends BaseController
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\AulaResource
     */
    public function index()
    {
        $aulas = Aula::all();
        
        return $this->sendResponse(AulaResource::collection($aulas), 'Aulas retrieved successfully.', 'aulas');
    }
    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $input = $request->all();

        $validator = Validator::make($input, [
            'codigo' => 'required',
            'dono' => 'required'
        ]);

        if ($validator->fails()) {
            return response(content: $validator->errors(),status: Response::HTTP_BAD_REQUEST);
        }

        $aula = Aula::create($input);

        return response()->json($aula, Response::HTTP_CREATED);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $aula = Aula::find($id);

        if (is_null($aula)) {
            return response(status: Response::HTTP_NOT_FOUND);
        }

        return response(content: $aula, status: Response::HTTP_OK);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Aula $aula)
    {
        $input = $request->all();

        $validator = Validator::make($input, [
            'code' => 'required',
            'owner' => 'required'
        ]);

        if ($validator->fails()) {
            return response(content: $validator->errors(), status: Response::HTTP_BAD_REQUEST);
        }

        $aula->code = $input['code'];
        $aula->owner = $input['owner'];
        $aula->name = $input['name'];
        $aula->save();

         return response(content:$aula, status:Response::HTTP_OK);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(Aula $aula)
    {
        $aula->delete();

        return response(status:Response::HTTP_NO_CONTENT);
    }

    //Mobile

    public function getAula($codigo = null)
    {
        
        if (is_null($codigo)) {
            return response(content: 'Codigo da sala não informado', status: Response::HTTP_BAD_REQUEST);
        }

        if (!$this->_is_valid_uuid($codigo)) {
            return response(content: 'Codigo da sala Inválido', status: Response::HTTP_BAD_REQUEST);
        }

        $aula = Aula::where('codigo', $codigo)->with('objetos3d')->get();

        if (is_null($aula)) {
            return response(status: Response::HTTP_NOT_FOUND);
        }
        return response(content: $aula, status:Response::HTTP_OK);
    }

    private function _is_valid_uuid($uuid) {
        $pattern = '/^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$/i';
        return preg_match($pattern, $uuid) === 1;
    }


    public function getAulas($id)
    {
        // Primeiro, encontre a disciplina pelo código
        $disciplina = Disciplina::find($id);

        if (is_null($disciplina)) {
            return response()->json(['message' => 'Disciplina não encontrada.'], Response::HTTP_NOT_FOUND);
        }

        // Encontre todas as aulas que pertencem a essa disciplina
        $aulas = Aula::where('disciplina_id', $disciplina->id)
                    ->with('objetos3d')
                    ->get();

        if ($aulas->isEmpty()) {
            return response()->json(['message' => 'Nenhuma aula encontrada para esta disciplina.'], Response::HTTP_NOT_FOUND);
        }

        return response()->json(['success' => true, 'data' => $aulas], Response::HTTP_OK);
    }


    public function getAllAulas()
    {
        $aulas = Aula::with('objetos3d')->get();

        if (is_null($aulas)) {
            return response(status: Response::HTTP_NOT_FOUND);
        }

        return $this->sendResponse(AulaResource::collection($aulas), 'Aulas retrieved successfully.', 'aulas');
    }
}
