
function getProducts() {

    $.ajax({
        url: 'http://localhost:8080/StockMavenProject/api/products/consultall',
        type: 'GET',
        contentType: 'application/json',
        success: function (data) {
            console.log(data);

    

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
            console.log("la");
            
        console.log(data);
            if (data.length > 10) {
                for (let i = data.length - 11; i < data.length; i++) {
                    const element = data[i];
                    if(element.produtoAlbergaId!=-1){
                    var shelves = "<tr><td>" + element.id  + "</td><td>" + element.capacidade+ "</td><td>" +element.precoAluguer  + "</td><td>" +element.produtoAlbergaId +  "</td></tr>";
                    }
                    else {
                        var shelves = "<tr><td>" + element.id  + "</td><td>" + element.capacidade+ "</td><td>" +element.precoAluguer  + "</td><td>" + "nao tem produto" +  "</td></tr>";
                   
                    }
                    $('#tabelaprateleira').append(shelves);
                }
            }
            else{

                for (let i = 0; i < data.length; i++) {
                    const element = data[i];
                    var shelves = "<tr><td>" + element.id  + "</td><td>" + element.capacidade+ "</td><td>" +element.precoAluguer  + "</td><td>" +element.produtoAlbergaId + "</td></tr>";
                    $('#tabelaprateleira').append(shelves);
                }
            }
        }
    });
};
getShelves()




function addProducts() {
  

    var inputshelves = $('#listaprateleiras').val();
    var listShelves = inputshelves.split(",");
    console.log(inputshelves);
    var listShelves1=[];
    
    for (let i =0; i< listShelves.length; i++){
        
        listShelves1.push({"id": parseInt(listShelves[i])});
        }
    
        console.log(listShelves1);

     var product = {"listShelfIn":listShelves1,"valorDesconto":$('#discountValue').val(),"iva":$('#iva').val(),"pvp":$('#pvp').val()};
         

    $.ajax({
        url: 'http://localhost:8080/StockMavenProject/api/products/new',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(product),
        success: function (data) {
         
            console.log(data);
            $("#salvar").click(window.location.reload());
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

function getListShelfInProduct(){
    var pesquisar = $('#input3').val();


    $.ajax({
   url: `http://localhost:8080/StockMavenProject/api/products/shelves/${pesquisar}`,
    type: 'GET',
    contentType: 'application/json',
    success: function (data) {
        console.log(data);

            for (let i = 0; i < data.length; i++) {
                const element = data[i];

                var showdata = "<tr><td>" + element.id + "</td><td>" + element.capacidade + "</td><td>" + element.precoAluguer  + "</td></tr>";

                $('#tablelidtshelf').fadeIn();
                $('#tablelidtshelf').append(showdata);

            }

        }


});
};



function addreplaceProducts() {
       

    var productreplace = {"id":$('#iptreplaceidproduto').val(),"valorDesconto":$('#replacedv').val(),"iva":$('#replaceiva').val(),"pvp":$('#replacepvp').val()};
         

    $.ajax({
        url: `http://localhost:8080/StockMavenProject/api/products/edit`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(productreplace),
        success: function (productreplace) {
            console.log(productreplace);
           $("#replaceproduct").click(window.location.reload());
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


function addShelves() {
  
    if($('#productId').val()!==""||$('#productId').val()==null){
    var shelf = {"capacidade":$('#capacity').val(),"produtoAlberga":{id:$('#productId').val()},"precoAluguer":$('#rentPrice').val()};
    }
    else{
        var shelf = {"capacidade":$('#capacity').val(),"precoAluguer":$('#rentPrice').val()};
   
    }
    $.ajax({
        url: 'http://localhost:8080/StockMavenProject/api/shelves/new',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(shelf),
        success: function (shelf) {
            console.log(shelf);
            $("#salvar2").click(window.location.reload());
        }
    });
};




function getShelvesbyId() {
    var pesquisar = $('#iptpes2').val();

    $.ajax({
        url: `http://localhost:8080/StockMavenProject/api/shelves/consult/${pesquisar}`,
        type: 'GET',
        contentType: 'application/json',
        success: function (data) {
            console.log("id=" + data);
            var showdata = "<tr><td>" + data.capacidade + "</td><td>" + data.precoAluguer  + "</td><td>" +data.produtoAlbergaId + "</td></tr>";

            $("#tableshelfbyid").fadeIn();
            $("#tableshelfbyid").append(showdata);

        }
    });
                 
};



function addreplaceShelves() {


    var shelfreplace = {"id":$('#iptreplaceidshelf').val(),"capacidade":$('#replacecapacity').val(),"produtoAlberga":{"id":$('#replaceprodutoid').val()},"precoAluguer":$('#replacerentprice').val()};

    $.ajax({
        url: `http://localhost:8080/StockMavenProject/api/shelves/edit`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(shelfreplace),
        success: function (shelfreplace) {
            console.log(shelfreplace);
        $('#replaceshelf').click(window.location.reload());  
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






