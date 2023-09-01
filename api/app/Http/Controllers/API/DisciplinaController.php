<?php
     
namespace App\Http\Controllers\API;
     
use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Models\Disciplina;
use Validator;
use App\Http\Resources\DisciplinaResource;
     
class DisciplinaController extends BaseController
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $disciplinas = Disciplina::all();
      
        return $this->sendResponse(DisciplinaResource::collection($disciplinas), 'Disciplinas retrieved successfully.');
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
            'name' => 'required',
            'initial' => 'required'
        ]);
     
        if($validator->fails()){
            return $this->sendError('Validation Error.', $validator->errors());       
        }
     
        $disciplina = Disciplina::create($input);
     
        return $this->sendResponse(new DisciplinaResource($disciplina), 'Disciplina created successfully.');
    } 
   
    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $disciplina = Disciplina::find($id);
    
        if (is_null($disciplina)) {
            return $this->sendError('Disciplina not found.');
        }
     
        return $this->sendResponse(new DisciplinaResource($disciplina), 'Disciplina retrieved successfully.');
    }
    
    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Disciplina $disciplina)
    {
        $input = $request->all();
     
        $validator = Validator::make($input, [
            'name' => 'required',
            'initial' => 'required'
        ]);
     
        if($validator->fails()){
            return $this->sendError('Validation Error.', $validator->errors());       
        }
     
        $disciplina->name = $input['name'];
        $disciplina->initial = $input['initial'];
        $disciplina->save();
     
        return $this->sendResponse(new DisciplinaResource($disciplina), 'Disciplina updated successfully.');
    }
   
    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(Disciplina $disciplina)
    {
        $disciplina->delete();
     
        return $this->sendResponse([], 'Disciplina deleted successfully.');
    }
}