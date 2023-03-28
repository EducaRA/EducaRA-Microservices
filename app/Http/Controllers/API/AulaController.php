<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Models\Aula;
use Validator;
use App\Http\Resources\AulaResource;
use App\Http\Resources\AulaResourceMobile;

class AulaController extends BaseController
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $aulas = Aula::all();
        return $this->sendResponse(AulaResource::collection($aulas), 'Aulas retrieved successfully.');
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
            return $this->sendError('Validation Error.', $validator->errors());
        }

        $aula = Aula::create($input);

        return $this->sendResponse(new AulaResource($aula), 'Aula created successfully.');
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
            return $this->sendError('Aula not found.');
        }

        return $this->sendResponse(new AulaResource($aula), 'Aula retrieved successfully.');
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
            return $this->sendError('Validation Error.', $validator->errors());
        }

        $aula->code = $input['code'];
        $aula->owner = $input['owner'];
        $aula->name = $input['name'];
        $aula->save();

        return $this->sendResponse(new AulaResource($aula), 'Aula updated successfully.');
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

        return $this->sendResponse([], 'Aula deleted successfully.');
    }

    //Mobile

    public function getAula($codigo = null)
    {
        
        if (is_null($codigo)) {
            return $this->sendError('Codigo da sala não informado');
        }

        $aula = Aula::where('codigo', $codigo)->with('objetos3d')->get();

        if (is_null($aula)) {
            return $this->sendError('Aula not found.');
        }
        return $this->sendResponse(AulaResourceMobile::collection($aula), 'Aula obtida com sucesso');
    }
}
