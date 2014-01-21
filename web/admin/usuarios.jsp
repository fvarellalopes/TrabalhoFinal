<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="../img/favicon.png">
        <title>Lista de Usuários</title>
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/dataTables.bootstrap.css" rel="stylesheet">
        <link href="../css/geral.css" rel="stylesheet">
    </head>

    <body>
        <%@include file="menu.jsp" %>
        <div class="container">
            <div class="starter-template">
                <h1>Cadastro de Usuários</h1>
            </div>
            <!-- Botões de ação -->
            <a class="btn btn-primary" id="novo" href="usuarioscadastro.jsp" role="button">Novo</a>
            <a class="btn btn-success" id="editar" role="button">Editar</a>
            <a class="btn btn-danger" id="excluir" role="button">Excluir</a>
            
            <!-- Mensagens de Erro -->
            <div class="alert alert-success" id="div_OK" style="display: none">
            </div>
            <div class="alert alert-danger" id="div_ERRO" style="display: none">
            </div>
            
            <div class="spacer"><br /></div>
            
            <!-- TABELA -->
            <table class="table table-striped table-bordered display"
                   id="exemplo" width="100%">
                                <thead>
                    <tr>
                        <th width="20%">Código</th>
                        <th width="40%">Nome</th>
                        <th width="20%">Email</th>
                        <th width="20%">Login</th>
                    </tr>
                </thead>
                
                <tbody>        
                </tbody>
                
                <tfoot>
                    <tr>
                        <th width="20%">Código</th>
                        <th width="40%">Nome</th>
                        <th width="20%">Email</th>
                        <th width="20%">Login</th>
                    </tr>
                </tfoot>
            </table>
            <div class="spacer"></div>
        </div><!-- /.container -->

        <script type="text/javascript" src="../js/jquery-2.0.3.js"></script>
        <script type="text/javascript" src="../js/jquery.dataTables.js"></script>
        <script type="text/javascript" charset="utf-8" src="../js/bootstrap.js" ></script>
        <script type="text/javascript" charset="utf-8" src="../js/dataTables.bootstrap.js" ></script>
        <script type="text/javascript" charset="utf-8" src="../js/bootbox.js" ></script>
        
        <script type="text/javascript" charset="UTF-8" id="init-code">
            var oTable;
            
            $(document).ready(function(){
                //Popula a tabela dos os dados do servlet
                oTable = $('#exemplo').dataTable({
                    "bProcessing": true,
                    "sAjaxSource": 'UsuarioController?acao=listar'
                });
                
                /* Código para selecionar as linhas da tabela, ao clicar 
                 * em uma linha
                 */
                $("#exemplo tbody").click(function(event) {
                    $(oTable.fnSettings().aoData).each(function() {
                        $(this.nTr).removeClass('row_selected');
                    });
                    $(event.target.parentNode).addClass('row_selected');
                });

                //Seta a linguagem da message box para br;
                bootbox.setDefaults({
                    locale: "br"
                });
                
                //Evento ao clicar no botão editar
                $('#editar').click(function() {
                    var anSelected = fnGetRSelected(oTable);
                    if (anSelected.length !== 0) {
                        var colunas = $(anSelected).eq(0).find('td');
                        var id = colunas.eq(0).text();
                        var destino = 'usuarioscadastro.jsp?id=' + id;
                        $(window.document.location).attr('href', destino);
                    } else {
                        exibeMensagem('ERRO','Selecione um registro para editar.');
                    }
                }); //FIM EDITAR
                
                /* Evento ao clicar no botão excluir */
                $('#excluir').click(function() {
                    var anSelected = fnGetRSelected(oTable);
                    if (anSelected.length !== 0) {
                        bootbox.confirm('Deseja excluir o registro?', function(result) {
                            if (result) {
                                var colunas = $(anSelected).eq(0).find('td');
                                var id = colunas.eq(0).text();
                                var destino = 'UsuarioController?acao=excluir&usuarioid=' + id;
                                $.ajax({
                                    type: 'POST',
                                    url: destino,
                                    success: function(data) {
                                        var json = $.parseJSON(data);
                                        oTable.fnDeleteRow(anSelected[0]);
                                        if (json.situacao === 'OK') {
                                            exibeMensagem('ERRO','Registro removido com sucesso.');
                                        } else {
                                            exibeMensagem('ERRO','Falha ao remover o registro.');
                                        }
                                    }
                                });
                            }
                        });
                    } else {
                        exibeMensagem('ERRO','Selecione um registro para remover.');
                    }
                });//FIM EXCLUIR
                
            }); //READY
            
                        //Exibe as mensagens na página
            function exibeMensagem(situacao, mensagem){
                if (situacao === 'OK'){
                    $('#div_OK').html(mensagem);
                    $('#div_OK').fadeIn('fast');
                    $('#div_OK').fadeOut(2000);
                }else {
                    $('#div_ERRO').html(mensagem);
                    $('#div_ERRO').fadeIn('fast');
                    $('#div_ERRO').fadeOut(2000);
                }
            }
            
            /* Retorna as linhas selecionadas */
            function fnGetRSelected(oTableLocal) {
                return oTableLocal.$('tr.row_selected');
            }
            
        </script>
    </body>
</html>
