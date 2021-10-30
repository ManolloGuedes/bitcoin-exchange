package com.guedes.tech.resource;

import com.guedes.tech.model.Bitcoin;
import com.guedes.tech.service.BitcoinService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/bitcoins")
public class BitcoinResource {
    @Inject
    @RestClient
    BitcoinService bitcoinService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listAll() {
        return bitcoinService.list();
    }
}
