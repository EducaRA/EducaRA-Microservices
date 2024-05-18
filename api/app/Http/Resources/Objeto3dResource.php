<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class Objeto3dResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @return array<string, mixed>
     */
    public function toArray(Request $request): array
    {
        return [
            'id' => $this->id,
            'nome' => $this->nome,
            'descricao' => $this->descricao,
            'imagem' => $this->imagem,
            'filehash' => $this->filehash,
            'objeto' => $this->path,
            'extension'=> $this->extension,
            'size' => $this->size,
            'escala' => $this->escala,
            'created_at' => $this->created_at->format('Y-m-d\TH:m:s\Z'),
            'updated_at' => $this->updated_at->format('Y-m-d\TH:m:s\Z'),
        ];
    }
}
