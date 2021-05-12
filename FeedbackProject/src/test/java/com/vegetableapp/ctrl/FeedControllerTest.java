/*
 * package com.vegetableapp.ctrl;
 * 
 * import static org.hamcrest.CoreMatchers.is; import static
 * org.mockito.Mockito.when; import java.time.LocalDate; import
 * org.hamcrest.Matchers; import org.junit.Before; import
 * org.junit.jupiter.api.BeforeAll; import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks;
 * import org.mockito.Mock; import org.skyscreamer.jsonassert.JSONAssert; import
 * org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 * import org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.context.junit.jupiter.SpringExtension; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.RequestBuilder; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers; import
 * org.springframework.test.web.servlet.setup.MockMvcBuilders; import
 * com.vegetableapp.service.*;
 * 
 * @AutoConfigureMockMvc
 * 
 * @ExtendWith(SpringExtension.class) class FeedbackControllerTest {
 * 
 * @MockBean private FeedbackService service;
 * 
 * @InjectMocks private FeedbackController Feedctrl;
 * 
 * private MockMvc mockmvc;
 * 
 * @Test public void addBidTest() throws Exception { mockmvc =
 * MockMvcBuilders.standaloneSetup(bidcontroller).build(); Farmer farmer = new
 * Farmer(1, "ramnagar", "nellore"); Crop crop1 = new Crop(1, "rice", "rabi",
 * "nitrogen", 5.5, 20000, Status.Average, farmer); Bidder bidder1 = new
 * Bidder(1, "hyderabad", "432541", "BNZY398974", true); Bid bid1 = new Bid(1,
 * LocalDate.of(2020, 8, 18), 25000, true, crop1, bidder1); //
 * mockmvc=MockMvcBuilders.standaloneSetup(bidcontroller).build();
 * 
 * when(bidservice.addBid(bid1)).thenReturn(bid1);
 * mockmvc.perform(MockMvcRequestBuilders.get("/bids/add",
 * bid1)).andExpect(MockMvcResultMatchers.status().isOk())
 * .andExpect(MockMvcResultMatchers.jsonPath("$.bidId", is(1)))
 * .andExpect(MockMvcResultMatchers.jsonPath("$.date", Matchers.is(2020 - 8 -
 * 18))) .andExpect(MockMvcResultMatchers.jsonPath("$.amount",
 * Matchers.is(25000))); } }
 */