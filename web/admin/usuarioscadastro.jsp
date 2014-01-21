<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="../img/favicon.ico">
        <title>Cadastro de Usuários</title>        
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/geral.css" rel="stylesheet">
    </head>
    <body onload="loadData()">
        <%@include file="menu.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-md-1 col-md-offset-3">
                    <fieldset>
                        <form id="frm" name="frm" class="well span6" role="form" method="POST" 
                              action="UsuarioController?acao=salvar" >
                            <legend>Cadastro de Usuários</legend>

                            <div class="form-group">
                                <label for="id">Código</label>
                                <input type="text" class="form-control" readonly id="usuarioid" name="usuarioid" 
                                       value="${param.id}" />
                            </div>

                            <div class="form-group">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" id="nome" name="nome" 
                                       value=""/>
                            </div>
                            <div class="form-group">
                                <label for="login">Login</label>
                                <input type="text" class="form-control" id="login" name="login" 
                                       value=""/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email" 
                                       value=""/>
                            </div>

                            <div class="form-group">
                                <label for="senha">Senha</label>
                                <input type="password" class="form-control" id="senha" name="senha" 
                                       value=""/>
                            </div>
                            <div class="form-group">
                                <label for="confirmar">Confirmar Senha</label>
                                <input type="password" class="form-control" id="senhaconf" name="senhaconf" 
                                       value=""/>
                            </div>
                            <button type="reset" class="btn btn-default">
                                Limpar
                            </button>
                            <button type="submit" class="btn btn-primary">
                                Salvar
                            </button>
                            <br /><br />
                            <div id="divErro" class="alert alert-danger" style="display: none;"></div>
                            <div id="divSucesso" class="alert alert-success" style="display: none;"></div>
                    </fieldset>
                    </form>
                </div>
            </div>
        </div><!-- /.container -->

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script type="text/javascript" src="../js/jquery-2.0.3.js"></script>
        <script type="text/javascript" src="../js/bootstrap.js"></script>
        
        <script type="text/javascript">
        var form = $('#frm');
        //No submit do form salva os dados
        form.submit(function() {
            //Os dados do forumário fazem comunicação através de Ajax
            //Com o servlet de usuários
            $.ajax({
                type: form.attr('method'),
                url: form.attr('action'),
                data: form.serialize(),
                //Caso a comunicação ocorra com sucesso, a variável data
                //possui o retorno do servlet
                success: function(data) {
                    
                    //a variável retorno vai conter as propriedades vindas
                    //do UsuarioController na ação Salvar.
                    var retorno = $.parseJSON(data);
                    $("#divErro").hide("fast");
                    $("#divSucesso").hide("fast");
                    if (retorno.situacao === "OK") {
                        $("#usuarioid").attr('value', retorno.id);
                        $("#divSucesso").html(retorno.mensagem);
                        $("#divSucesso").show("slow");
                    } else {
                        var msg = "";
                        $.each(retorno.mensagem, function() {
                            $.each(this, function(index, value) {
                                msg += value + '<br />';
                            });
                        });
                        $("#divErro").html(msg);
                        $("#divErro").show("slow");
                    }
                }
            });
            return false;
        }); //FIM SALVAR

        //Carrega dados do usuário
        function loadData() {
            var id = $("#usuarioid").val();
            if (id <= 0) {
                caregacombo(0);
            } else {
                var destino = 'UsuarioController?acao=carregar&usuarioid=' + id;
                $.ajax({
                    type: 'POST',
                    url: destino,
                    success: function(data) {
                        var json = $.parseJSON(data);
                        $("#usuarioid").val(json.usuarioid);
                        $("#nome").val(json.nome);
                        $("#email").val(json.email);
                        $("#login").val(json.login);
                    }

                });
            }
        }//fim loadData

        </script>
    </body>
</html>



