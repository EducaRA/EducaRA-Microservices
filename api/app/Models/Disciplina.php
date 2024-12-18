<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Disciplina extends Model
{
    use HasFactory;

    protected $fillable = [
        'sigla', 'nome', 'imagem' 
    ];

    public function aulas()
    {
        return $this->hasMany(Aula::class);
    }
}
