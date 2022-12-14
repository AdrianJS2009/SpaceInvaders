package com.politecnicomalaga;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class SpaceInvaders extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture img_NaveEnemiga;
	NaveAliada jugador;
	NaveEnemiga[] malos;


	int ancho_enemigos = 11;
	int alto_enemigos = 5;
	int enemigos = 40;
	int i = 0;


	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("navejugador.png");
		jugador = new NaveAliada(img);
		img_NaveEnemiga = new Texture("navealien.png");
		malos = new NaveEnemiga[ancho_enemigos * alto_enemigos];

		for (int y = 0; y < alto_enemigos; y++) {
			for (int x = 0; x < alto_enemigos; x++) {
				Vector2 position = new Vector2(x* enemigos,y* enemigos);
				position.x += Gdx.graphics.getWidth()/2;
				position.y +=Gdx.graphics.getHeight();
				position.x -= (ancho_enemigos / 2) * enemigos;
				position.y -= (alto_enemigos)* enemigos;
				malos[i] = new NaveEnemiga(position,img_NaveEnemiga,Color.GREEN);
				i++;
			}
			}

	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		jugador.Pintarse(batch);
		for(i = 0; i < malos.length; i++) {
				malos[0].Pintarse(batch);
		}
		batch.end();
		}
	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}
}