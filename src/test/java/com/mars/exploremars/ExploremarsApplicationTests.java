package com.mars.exploremars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.exploremars.ports.requests.CreateMissionRequest;
import com.mars.exploremars.ports.responses.SimpleMissionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ExploremarsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldCreateNewMission () throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		CreateMissionRequest body = new CreateMissionRequest(5,5);
		SimpleMissionResponse expectedResponse = new SimpleMissionResponse(0, 5, 5);

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/missions/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(body)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectedResponse)));
	}

	@Test
	void shouldGetCreatedMission () throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		CreateMissionRequest body = new CreateMissionRequest(5,5);
		SimpleMissionResponse expectedResponse = new SimpleMissionResponse(0, 5, 5);

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/missions/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(body)));

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/missions/0"))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectedResponse)));

	}

}
