package fr.banque;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import jakarta.jws.WebParam;

@WebService(
        name = "VirementBancaireService",
        targetNamespace = "http://banque.fr/"
)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface VirementBancaireService {

    @WebMethod
    ResultatVirement effectuerVirement(
            @WebParam(name = "virementRequest") VirementRequest request
    ) throws VirementException;
}