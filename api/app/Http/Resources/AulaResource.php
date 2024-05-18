<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class AulaResource extends JsonResource
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
            'codigo' => $this->codigo,
            'conteudos' => Objeto3dResource::collection($this->whenLoaded('objetos3d')),
            'created_at' => $this->created_at->format('Y-m-d\TH:m:s\Z'),
            'updated_at' => $this->updated_at->format('Y-m-d\TH:m:s\Z'),
        ];
    }
}
