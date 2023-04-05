<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('aulas', function (Blueprint $table) {
            $table->id();
            $table->string('nome');
            $table->uuid('codigo');
            $table->string('observacao');
            $table->string('turma');
            $table->unsignedBigInteger('dono_id'); //dono da sala (professor)
            $table->unsignedBigInteger('disciplina_id');
            $table->foreign('dono_id')->references('id')->on('users');
            $table->foreign('disciplina_id')->references('id')->on('disciplinas');
            $table->timestamps();
            $table->softDeletes();
        });	
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('aulas');
    }
};
