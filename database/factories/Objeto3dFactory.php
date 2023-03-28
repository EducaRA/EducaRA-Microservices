<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Discipline>
 */
class Objeto3dFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'nome' => $this->faker->randomElement(['Português', 'Matemática', 'Química', 'Física', 'Biologia', 'Geografia', 'Geometria']),
            'descricao' => $this->faker->randomElement(['POR', 'MAT', 'HIS', 'GEO', 'BIO', 'FIS']),
            'imagem' => $this->faker->randomElement(['2022.1', '2022.2', '2022.3', '2022.4', '2022.4', 'FIS']),
            'escala' => $this->faker->randomFloat(3, 0, 50),
            'disciplina_id' => 1,
            'aula_id' => 1
        ];
    }
}
