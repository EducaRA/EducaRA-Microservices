<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Discipline>
 */
class AulaFactory extends Factory
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
            'observacao' => $this->faker->randomElement(['POR', 'MAT', 'HIS', 'GEO', 'BIO', 'FIS']),
            'turma' => $this->faker->randomElement(['2022.1', '2022.2', '2022.3', '2022.4', '2022.4', 'FIS']),
            'dono_id' => 11,
            'disciplina_id' => 1
        ];
    }
}
