﻿using ImobiliariaCrescer.Infraestrutura.Entidades;
using ImobiliariaCrescer.Infraestrutura.Repositorios;
using ImobiliariaCrescer.WebAPI.App_Start;
using ImobiliariaCrescer.WebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace ImobiliariaCrescer.WebAPI.Controllers
{

    [AllowAnonymous]
    [RoutePrefix("api/acessos")]
    public class UsuariosController : ApiController
    {
        private UsuarioRepositorio repositorio = new UsuarioRepositorio();

        [HttpPost, Route("registrar")]
        public HttpResponseMessage Registrar([FromBody]RegistrarUsuarioModel model)
        {
            if (repositorio.Obter(model.Email) == null)
            {
                var usuario = new Usuario(model.Nome, model.Email, model.Senha);

                if (usuario.Validar())
                {
                    repositorio.Salvar(usuario);
                }
                else
                {
                    return ResponderErro(usuario.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Usuário já existe.");
            }

            return ResponderOK();
        }

        [HttpPost, Route("resetarsenha")]
        public HttpResponseMessage ResetarSenha(string email)
        {
            var usuario = repositorio.Obter(email);
            if (usuario == null)
                return ResponderErro(new string[] { "Usuário não encontrado." });

            var novaSenha = usuario.ResetarSenha();

            if (usuario.Validar())
            {
                repositorio.Alterar(usuario);
                // EmailService.Enviar(usuario.Email, "Crescer 2017-1", $"Olá! sua senha foi alterada para: {novaSenha}");
            }
            else
                return ResponderErro(usuario.Mensagens);

            return ResponderOK();
        }

        // Exige que o usuário se autentique
        [AutenticacaoBasic64]
        [HttpGet, Route("usuario")]
        public HttpResponseMessage Obter()
        {
            // só pode obter as informações do usuário corrente (logado, autenticado)
            var usuario = repositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (usuario == null)
                return ResponderErro("Usuário não encontrado.");

            return ResponderOK(new { usuario.Nome, usuario.Permissoes, usuario.Email });
        }

        public HttpResponseMessage ResponderOK(object dados = null)
        {
            return Request.CreateResponse(HttpStatusCode.OK, new { dados });
        }

        public HttpResponseMessage ResponderErro(params string[] mensagens)
        {
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens });
        }

        public HttpResponseMessage ResponderErro(IEnumerable<string> mensagens)
        {
            return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens });
        }
    }
}