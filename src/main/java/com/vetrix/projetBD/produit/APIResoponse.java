package com.vetrix.projetBD.produit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResoponse<T>{
    int recordCount;
    T response;
}
