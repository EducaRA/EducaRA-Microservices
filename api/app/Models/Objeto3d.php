<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Ramsey\Uuid\Uuid;

class Objeto3d extends Model
{
    use HasFactory;
    protected $table = 'objetos_3d';

    protected $fillable = [
        'nome', 'descricao', 'size', 'extension', 'path', 'escala'
    ];

    protected static function booted()
    {
        static::creating(fn (Objeto3d $objeto3d) => $objeto3d->codigo = (string) Uuid::uuid4());
    }
    
}
