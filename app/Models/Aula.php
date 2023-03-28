<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\SoftDeletes;
use Ramsey\Uuid\Uuid;

class Aula extends Model
{
    use SoftDeletes;
    use HasFactory;

    protected $table = 'aulas';
    protected $fillable = [
        'codigo', 'dono', 'nome', 'observacao', 'turma'
    ];

    protected static function booted()
    {
        static::creating(fn (Aula $aula) => $aula->codigo = (string) Uuid::uuid4());
    }

    //Muitas salas pertencem a um ou muitos objetos (N,N)
    public function objetos3d()
    {
        return $this->hasMany(Objeto3d::class);
    }

    // uma sala pertencem a apenas uma disciplina obrigatória
    public function disciplina()
    {
        return $this->belongsTo(Disciplina::class);
    }

    // uma sala possui um dono obrigatório
    public function dono()
    {
        return $this->hasOne(User::class, 'id', 'dono_id');
    }
}
