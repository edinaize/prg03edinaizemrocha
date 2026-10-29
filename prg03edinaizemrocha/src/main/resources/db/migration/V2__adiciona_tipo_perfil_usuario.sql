/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  edina
 * Created: 28 de out. de 2026
 */

ALTER TABLE usuarios
    ADD COLUMN tipo_perfil VARCHAR(20) NOT NULL DEFAULT 'USUARIO';

ALTER TABLE usuarios
    ADD CONSTRAINT ck_usuarios_tipo_perfil
    CHECK (tipo_perfil IN ('USUARIO', 'ARTISTA'));