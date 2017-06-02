using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Web;
using System.Web.Http;
using System.Web.Http.Controllers;

namespace EditoraCrescer.WebAPI.App_Start
{
    public class AutenticacaoBasic64 : AuthorizeAttribute
    {
        public override void OnAuthorization(HttpActionContext actionContext)
        {
            string tokenAutenticacao =
                    actionContext.Request.Headers.Authorization.Parameter;
            string decodedTokenAutenticacao =
                    Encoding.Default.GetString(Convert.FromBase64String(tokenAutenticacao));
            string[] userNameAndPassword = decodedTokenAutenticacao.Split(':');

            if (userNameAndPassword[0] == "leonardo morais" && userNameAndPassword[1] == "123456")
            {
                actionContext.Response = actionContext.Request.CreateResponse(HttpStatusCode.Unauthorized);
            }
        }
    }
}