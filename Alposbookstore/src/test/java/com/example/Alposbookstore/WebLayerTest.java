//package com.example.Alposbookstore;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//@ExtendWith(SpringExtension.class)
//@AutoConfigureMockMvc
//public class WebLayerTest {
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	public void testDefaultMessage() throws Exception{
//		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
//		.andExpect(content().string(containsString("Hello")));
//	}
//
//}
