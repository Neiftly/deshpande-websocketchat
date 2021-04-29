/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deshpande;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Vinayak
 */
public class MessageDecoder implements Decoder.Text<Message> {

    @Override
    public Message decode(String string) throws DecodeException {
        JsonObject jsonObject = Json.createReader(new StringReader(string)).readObject();
        return new Message(jsonObject);
    }

    @Override
    public boolean willDecode(String string) {
        boolean result;
        try {
            JsonObject jsonObject = Json.createReader(new StringReader(string)).readObject();
            result = true;
        } catch (JsonException jex) {
            result = false;
        }
        return result;
    }

    @Override
    public void init(EndpointConfig config) {
        
    }

    @Override
    public void destroy() {
        
    }

}
