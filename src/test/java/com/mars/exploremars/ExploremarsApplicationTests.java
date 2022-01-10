package com.mars.exploremars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.exploremars.core.Direction;
import com.mars.exploremars.core.Position;
import com.mars.exploremars.ports.requests.CreateMissionRequest;
import com.mars.exploremars.ports.requests.LaunchProbeRequest;
import com.mars.exploremars.ports.responses.SimpleMissionResponse;
import com.mars.exploremars.ports.responses.SimpleProbeResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ExploremarsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	@DirtiesContext
	void shouldCreateNewMission () throws Exception {

		CreateMissionRequest body = new CreateMissionRequest(5,5);
		SimpleMissionResponse expectedResponse = new SimpleMissionResponse(0, 5, 5);

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/missions")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(body)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectedResponse)));
	}

	@Test
	@DirtiesContext
	void shouldGetCreatedMission () throws Exception {

		CreateMissionRequest body = new CreateMissionRequest(5,5);
		SimpleMissionResponse expectedResponse = new SimpleMissionResponse(0, 5, 5);

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/missions")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(body)));

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/missions/0"))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectedResponse)));

	}

	@Test
	void shouldReturn404IfMissionDoesNotExist () throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/missions/0"))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError());

	}

	@Test
	@DirtiesContext
	void shouldLaunchProbe() throws Exception {

		CreateMissionRequest missionBody = new CreateMissionRequest(5,5);
		LaunchProbeRequest probeBody = new LaunchProbeRequest("N", 1, 2);
		SimpleProbeResponse expectedResponse = new SimpleProbeResponse(0, Direction.NORTH, new Position(1,2));

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/missions")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(missionBody)));

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/missions/0/launch")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(probeBody)))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(expectedResponse)));
	}
}
