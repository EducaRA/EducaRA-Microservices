<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class DisciplinaResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        // $aula = new AulaResource
        return [
            'id' => $this->id,
            'codigo' => $this->codigo,
            'nome' => $this->nome,
            'sigla' => $this->sigla,
            'imagem' => $this->imagem,
            'aulas' => AulaResource::collection($this->whenLoaded('aulas')),
            'created_at' => $this->created_at->format('Y-m-d\TH:m:s\Z'),
            'updated_at' => $this->updated_at->format('Y-m-d\TH:m:s\Z'),
        ];
    }
}
