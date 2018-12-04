package io.altar.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.business.ProductBusiness;
import io.altar.model.Product;

@Path("/products")
public class ProductServices {


	@GET
	@Path("health")
	@Produces(MediaType.TEXT_PLAIN)
	public String health() {
		return "Api is working";
	}

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String health2() {
		return "Api is working";
	}

	//criar produto	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product newProduct(Product product1) {

		ProductBusiness.createProduct(product1);

		return product1;

	}


	//  editar produto	

	@PUT
	@Path ("edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product editProduct(@PathParam("id") long id, Product product1) {

		ProductBusiness.editProduct(product1);	
		return product1;


	}

	//consultar produto

	@GET
	@Path("consult/{id}")
	@Produces(MediaType.APPLICATION_JSON)

	public Product consultProduct (@PathParam("id") long id) {

	
		return ProductBusiness.consultByIdProduct(id);

	}

	//remover produto

	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)

	public String deleteProduct (@PathParam("id") long id) {

		ProductBusiness.removeProduct(id);
		

		return "o produto foi removido.";

	}



}
