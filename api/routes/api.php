<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

use App\Http\Controllers\API\
{
   DisciplinaController,
   Objeto3dController,
   AulaController
};

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

Route::middleware('api')->get('/user', function (Request $request) {
    return $request->user();
});

Route::middleware('api')->group(function () {

    Route::apiResources([
       'disciplinas' => DisciplinaController::class,
       'objetos3d' => Objeto3dController::class,
       'aulas' => AulaController::class,
    ]);
 
    Route::get('objetos3d/{objeto_3d}/download', [Objeto3dController::class, 'download'])->name('objetos3d.download');
 
 });
 
 //API ROUTES FOR APP MOBILE
 
 Route::prefix('mobile')->group(function () {

    Route::get('/aulas',[AulaController::class, 'getAllAulas'])->name('mobile.aulas.index');
    //Route::get('/aulas/{codigo}',[AulaController::class, 'getAula'])->name('mobile.aulas.show');
    Route::get('/aulas/{codigo}',[AulaController::class, 'getAulas'])->name('mobile.disciplinas.aulas.show');
    Route::get('/objetos3d/{codigo}', [Objeto3dController::class, 'getObjeto3d'])->name('mobile.objetos3d.show');
    Route::get('/objetos3d/{codigo}/download', [Objeto3dController::class, 'downloadObjeto3d'])->name('mobile.objetos3d.download');
 
 });

