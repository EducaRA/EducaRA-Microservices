<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Models\Objeto3d;
use Validator;
use App\Http\Resources\Objeto3dResource;
use Illuminate\Support\Facades\File;

class Objeto3dController extends BaseController
{
    /**
     * Pasta para upload dos arquivos 3d
     **/
    private $upload_folder = "objetos";

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $objeto3d = Objeto3d::all();

        return $this->sendResponse(Objeto3dResource::collection($objeto3d), 'Objetos 3D obtidos com sucesso.');
    }
    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {

        $input = $request->except('ar_file');

        $validator = Validator::make($input, [
            'nome' => 'required',
            'descricao' => 'required',
            'escala' => 'required'
        ]);

        if ($validator->fails()) {
            return $this->sendError('Validation Error.', $validator->errors());
        }

        $objeto3d = Objeto3d::create($input);

        $objeto3d->filehash = hash_file('md5', $request->ar_file);
        $objeto3d->size = $request->ar_file->getSize();
        $objeto3d->extension = $request->ar_file->getClientOriginalExtension();
        $objeto3d->path = $objeto3d->filehash . '.' . $objeto3d->extension;
        $request->ar_file->storeAs($this->upload_folder . '/' . $objeto3d->id, $objeto3d->filehash . '.' . $objeto3d->extension);
        $objeto3d->save();


        return $this->sendResponse(new Objeto3dResource($objeto3d), 'Objeto 3D criado com sucesso.');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $objeto3d = Objeto3d::find($id);

        if (is_null($objeto3d)) {
            return $this->sendError('Objeto 3D não encontrado');
        }

        return $this->sendResponse(new Objeto3dResource($objeto3d), 'Objetos 3D obtido com sucesso.');
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Objeto3d $objeto3d)
    {
        $input = $request->except('ar_file');

        $validator = Validator::make($input, [
            'name' => 'required',
            'description' => 'required'
        ]);

        if ($validator->fails()) {
            return $this->sendError('Validation Error.', $validator->errors());
        }

        $objeto3d->name = $input['name'];
        $objeto3d->description = $input['description'];

        if (isset($request->ar_file) && $request->ar_file->getSize() > 0) {
            $objeto3d->filehash = hash_file('md5', $request->ar_file);
            $objeto3d->size = $request->ar_file->getSize();
            $objeto3d->extension = $request->ar_file->getClientOriginalExtension();
            $path = $request->ar_file->storeAs($this->upload_folder . '/' . $objeto3d->id, $objeto3d->filehash . '.' . $objeto3d->extension);
            $objeto3d->path = $path;
        }

        $objeto3d->update();

        return $this->sendResponse(new Objeto3dResource($objeto3d), 'Objeto 3D atualizado com sucesso.');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(Objeto3d $objeto3d)
    {

        if (File::deleteDirectory(storage_path('app/' . $this->upload_folder) . '/' . $objeto3d->id)) {
            $objeto3d->delete();
            return $this->sendResponse([], 'Objeto 3D removido com sucesso.');
        } else
            return $this->sendError('Erro de Remoção', 'Não foi possível remover o arquivo', 400);
    }

    public function download($objeto3d)
    {
        // Check if file exists in app/storage/file folder
        $path = 'app/' . $this->upload_folder . $objeto3d->id . '/' . $objeto3d->filehash . '.' . $objeto3d->extension;
        $file_path = storage_path($path);
        return response()->download($file_path);
    }


    // Mobile

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function getObjeto3d($codigo)
    {

        if (is_null($codigo)) {
            return $this->sendError('Código do Objeto 3D não informado');
        }

        $objeto3d = Objeto3d::where('codigo', $codigo)->get();

        if (is_null($objeto3d)) {
            return $this->sendError('Objeto 3D não encontrado.');
        }

        return $this->sendResponse(Objeto3dResource::collection($objeto3d), 'Objeto 3D obtido com sucesso');
    }

    public function downloadObjeto3d($codigo)
    {
        // Check if file exists in app/storage/file folder

        if (is_null($codigo)) {
            return $this->sendError('Código do Objeto 3D não informado');
        }

        $objeto3d = Objeto3d::where('codigo', $codigo)->get();

        if (is_null($codigo)) {
            return $this->sendError('Objeto 3D não encontrado');
        }

        $path = 'app/' . $this->upload_folder . $objeto3d->id . '/' . $objeto3d->filehash . '.' . $objeto3d->extension;
        $file_path = storage_path($path);
        return response()->download($file_path);
    }
}
