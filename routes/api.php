<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::middleware('api')->get('/user', function (Request $request) {
    return $request->user();
});


Route::post('login', function (Request $request) {
    $credentials = $request->only(['email', 'password']);
    
    if(!$token = auth()->attempt($credentials)){
        abort(401, "Unauthorized");
    }

    return response()->json([
        'data' => [
            'token' => $token,
            'type' => 'bearer',
            'expires' => auth()->factory()->getTTL() * 60
        ]
    ]);

});

