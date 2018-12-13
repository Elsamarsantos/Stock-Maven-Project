
function getProducts() {

    $.ajax({
        url: 'http://localhost:8080/StockMavenProject/api/products/consultall',
        type: 'GET',
        contentType: 'application/json',
        success: function (data) {
            console.log(data);

            //  for (let i=0 ; i < data.length; i++) {
            //         const element = data[i];
                  
                    
            //            var produtos =  "<tr><td>" + element.id+ "</td><td>"+ element.valorDesconto + "</td><td>" + element.iva + "</td><td>" + element.pvp + "</td></tr>";

            //             $('#tabelaproduto').append(produtos);
            //          }


            if (data.length > 10) {
                for (let i = data.length - 11; i < data.length; i++) {
                    const element = data[i];
                    var produtos =  "<tr><td>" + element.id+ "</td><td>"+ element.valorDesconto + "</td><td>" + element.iva + "</td><td>" + element.pvp + "</td></tr>";

                    $('#tabelaproduto').append(produtos);
                }
            }
            else {
                for (let i = 0; i < data.length; i++) {
                    const element = data[i];
                    var produtos =  "<tr><td>" + element.id+ "</td><td>"+ element.valorDesconto + "</td><td>" + element.iva + "</td><td>" + element.pvp + "</td></tr>";

                    $('#tabelaproduto').append(produtos);

                }

            }

        }
    });
}
getProducts()

function getShelves() {
    $.ajax({
        url: 'http://localhost:8080/StockMavenProject/api/shelves/consultall',
        type: 'GET',
        contentType: 'application/json',
        success: function (data) {
        
            if (data.length > 10) {
                for (let i = data.length - 11; i < data.length; i++) {
                    const element = data[i];
                    var shelves = "<tr><td>" + element.id  + "</td><td>" + element.capacidade+ "</td><td>" +element.precoAluguer  + "</td><td>" +element.produtoAlberga  +  "</td></tr>";
                    $('#tabelaprateleira').append(shelves);
                }
            }
            else{

                for (let i = 0; i < data.length; i++) {
                    const element = data[i];
                    var shelves = "<tr><td>" + element.id  + "</td><td>" + element.capacidade+ "</td><td>" +element.precoAluguer  + "</td><td>" +element.produtoAlberga + "</td></tr>";
                    $('#tabelaprateleira').append(shelves);
                }
            }
        }
    });
};
getShelves()




function addProducts() {


     var product = new Product($('listaprateleiras').val(),$('#discountValue').val(),$('#iva').val(), $('#pvp').val());
         

    $.ajax({
        url: 'http://localhost:8080/StockMavenProject/api/products/new',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(product),
        
        success: function (newproduct) {
         
         
            console.log(newproduct);
            $("#salvar").click(window.location.reload());
        }
        
    });
    
};


function addShelves() {


    var shelf = new Shelf($('#capacity').val(), $('#rentPrice').val(), $('#productId').val());

    $.ajax({
        url: 'http://localhost:8080/StockMavenProject/api/shelves/new',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(shelf),
        success: function (newshelf) {
            console.log(newshelf);
            $("#salvar2").click(window.location.reload());
        }
    });
};






function getProductsbyId() {
    var pesquisar = $('#iptpes').val();

    $.ajax({
        url: `http://localhost:8080/StockMavenProject/api/products/consult/${pesquisar}`,
        type: 'GET',
        contentType: 'application/json',
        success: function (data) {
            console.log("id=" + data);

            var showdata=  "<tr><td>" + data.valorDesconto + "</td><td>" + data.iva + "</td><td>" + data.pvp + "</td></tr>";

       

            $("#tableprodutobyid").fadeIn();
            $("#tableprodutobyid").append(showdata);
        }
    });

};

function getShelvesbyId() {
    var pesquisar2 = $('#iptpes2').val();

    $.ajax({
        url: `http://localhost:8080/StockMavenProject/api/shelves/consul/${pesquisar}`,
        type: 'GET',
        contentType: 'application/json',
        success: function (data) {
            console.log("id=" + data);
            var showdata2 = "<tr><td>" + data.capacidade + "</td><td>" + data.produtoAlberga  + "</td><td>" + data.precoAluguer+ "</td></tr>";

            $("#tableshelfbyid").fadeIn();
            $("#tableshelfbyid").append(showdata);

        }
    });
                 
};

function addreplaceProducts() {
    var pesquisar3 = $('#iptreplaceidproduto').val();

    var productreplace = new Product($('#replacedv').val(), $('#replaceiva').val(), $('#replacepvp').val());

    $.ajax({
        url: `http://localhost:8080/StockMavenProject/api/products/edit/${pesquisar3}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(productreplace),
        success: function (replace) {
            console.log(replace);
        }
    });
};

function addreplaceShelves() {
    var pesquisar4 = $('#iptreplaceidshelf').val();

    var shelfreplace = new Product($('#replacecapacity').val(), $('#replaceprodutoid').val(), $('#replacerentprice').val());

    $.ajax({
        url: `http://localhost:8080/StockMavenProject/api/shelves/edit/${pesquisar4}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(shelfreplace),
        success: function (replace) {
            console.log(replace);
        }
    });
};


function deleteProducts() {
    var pesquisar5 = $('#iptdeleteidproduto').val();
    console.log(pesquisar5);


    $.ajax({
        url: `http://localhost:8080/StockMavenProject/api/products/delete/${pesquisar5}`,
        type: 'DELETE',
        contentType: 'application/json',

        success: function (apagar) {
        
         $("#botaodeleteproduct").click(window.location.reload());   
        }
        
    });
};

function deleteShelves() {
    var pesquisar6 = $('#iptdeleteidshelf').val();

    $.ajax({
        url: `http://localhost:8080/StockMavenProject/api/shelves/delete/${pesquisar6}`,
        type: 'DELETE',
        contentType: 'application/json',

        success: function (apagar) {
            $("#botaodeleteshelf").click(window.location.reload());
        }
    });
};






