<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Discipline>
 */
class DisciplinaFactory extends Factory
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
            'sigla' => $this->faker->randomElement(['POR', 'MAT', 'HIS', 'GEO', 'BIO', 'FIS'])
        ];
    }
}
