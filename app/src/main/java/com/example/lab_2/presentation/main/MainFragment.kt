package com.example.lab_2.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_2.databinding.FragmentMainBinding
import com.example.lab_2.model.TravelDestination

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val travelDestinations = listOf(
            TravelDestination(
                name = "Paris",
                shortDescription = "City of Love",
                description = "Paris is the capital city of France, known for its romantic ambiance, iconic landmarks such as the Eiffel Tower and Louvre Museum, and delicious cuisine.",
                url = "https://images.adsttc.com/media/images/5d44/14fa/284d/d1fd/3a00/003d/large_jpg/eiffel-tower-in-paris-151-medium.jpg?1564742900"
            ),
            TravelDestination(
                name = "Tokyo",
                shortDescription = "Vibrant Metropolis",
                description = "Tokyo is the bustling capital city of Japan, famous for its futuristic technology, vibrant street fashion, traditional temples, and delicious sushi.",
                url = "https://www.civitatis.com/blog/wp-content/uploads/2022/11/calle-akihabara-tokio.jpg"
            ),
            TravelDestination(
                name = "Rome",
                shortDescription = "Eternal City",
                description = "Rome is the historic capital city of Italy, renowned for its ancient ruins, including the Colosseum and Roman Forum, as well as Vatican City and St. Peter's Basilica.",
                url = "https://tourismmedia.italia.it/is/image/mitur/20220127150143-colosseo-roma-lazio-shutterstock-756032350-1?wid=1600&hei=900&fit=constrain,1&fmt=webp"
            ),
            TravelDestination(
                name = "Bora Bora",
                shortDescription = "Tropical Paradise",
                description = "Bora Bora is a stunning island in French Polynesia, known for its crystal-clear turquoise waters, overwater bungalows, and breathtaking coral reefs.",
                url = "https://cache.marriott.com/content/dam/marriott-renditions/BOBXR/bobxr-exterior-aerialview-1580-hor-wide.jpg?interpolation=progressive-bilinear&downsize=1440px:*"
            ),
            TravelDestination(
                name = "Cape Town",
                shortDescription = "Scenic Beauty",
                description = "Cape Town is a coastal city in South Africa, famous for its stunning natural landscapes, including Table Mountain, beautiful beaches, and diverse wildlife.",
                url = "https://cdn.britannica.com/41/75841-050-FAAE44F0/Table-Mountain-Cape-Town-Western-Bay-South.jpg"
            ),
            TravelDestination(
                name = "New York City",
                shortDescription = "The Big Apple",
                description = "New York City is a bustling metropolis in the United States, renowned for its iconic landmarks like Times Square, Statue of Liberty, Broadway shows, and diverse cultural offerings.",
                url = "https://www.frommers.com/system/media_items/attachments/000/868/461/s980/Frommers-New-York-City-Getting-Around-1190x768.jpg?1647177178"
            ),
            TravelDestination(
                name = "Sydney",
                shortDescription = "Harbor City",
                description = "Sydney is the largest city in Australia, famous for its stunning harbor, Sydney Opera House, Bondi Beach, and vibrant cosmopolitan lifestyle.",
                url = "https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/11/07/16/sydney-overview.jpg"
            )
        )

        val adapter = TravelDestinationsAdapter(travelDestinations, findNavController())

        binding.recyclerView.adapter = adapter
    }


}
