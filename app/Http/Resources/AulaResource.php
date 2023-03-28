<?php
  
namespace App\Http\Resources;
  
use Illuminate\Http\Resources\Json\JsonResource;
  
class AulaResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return array|\Illuminate\Contracts\Support\Arrayable|\JsonSerializable
     */
    public function toArray($request)
    {
        return [
            'id' => $this->id,
            'codigo' => $this->codigo,
            'nome' => $this->nome,
            'dono' => array(
                'nome' => $this->dono->name
            ),
            'observacao' => $this->observacao,
            'disciplina' => $this->disciplina,
            'turma' => $this->turma,
            'objetos_3d'=> $this->objetos3d,
            'created_at' => $this->created_at,
            'updated_at' => $this->updated_at,
        ];
    }

}