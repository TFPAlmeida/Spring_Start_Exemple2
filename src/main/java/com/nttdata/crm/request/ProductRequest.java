package com.nttdata.crm.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ProductRequest {

	@NotNull
	@NotEmpty(message = "ProductName shouldn't be null")
	private String name;
	
	@Min(value = 1, message  = "fasdffdfafdafd")
	private int quantity;
	
	@Min(0)
	private double price;
	
}
