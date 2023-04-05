<?php
  
namespace App\Http\Resources;
  
use Illuminate\Http\Resources\Json\JsonResource;
  
class AulaResourceMobile extends JsonResource
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
            'codigo' => $this->codigo,
            'nome' => $this->nome,
            'dono' => $this->dono->name,
            'observacao' => $this->observacao,
            'turma' => $this->turma,
            'disciplina' => array(
                'nome'=>$this->disciplina->nome,
                'sigla'=>$this->disciplina->sigla,
            ),
            'objetos_3d'=> $this->objetos3d,
            'created_at' => $this->created_at,
            'updated_at' => $this->updated_at,
        ];
    }

}