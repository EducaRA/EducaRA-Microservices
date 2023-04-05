<?php
  
namespace App\Http\Resources;
  
use Illuminate\Http\Resources\Json\JsonResource;
  
class Objeto3dResource extends JsonResource
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
            'nome' => $this->nome,
            'descricao' => $this->descricao,
            'size' => $this->size,
            'extension' => $this->extension,
            'escala' => $this->escala,
            'path' => $this->path,
            'created_at' => $this->created_at,//->format('d/m/Y'),
            'updated_at' => $this->updated_at,
        ];
    }
}