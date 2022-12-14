package com.suncorp.domain.model.models

data class AstronutResponse(
    var count: Int?,
    var next: String?,
    var previous: String?,
    var results: List<Astronut>?
)

data class Astronut(
    var agency: Agency?,
    var bio: String?,
    var date_of_birth: String?,
    var date_of_death: String?,
    var first_flight: String?,
    var flights: List<Flight>?,
    var id: Int?,
    var instagram: String?,
    var landings: List<Landing>?,
    var last_flight: String?,
    var name: String?,
    var nationality: String?,
    var profile_image: String?,
    var profile_image_thumbnail: String?,
    var status: Status?,
    var twitter: String?,
    var type: Type?,
    var url: String?,
    var wiki: String?

)

data class Agency(
    var abbrev: String?,
    var administrator: String?,
    var country_code: String?,
    var description: String?,
    var featured: Boolean?,
    var founding_year: String?,
    var id: Int?,
    var image_url: String?,
    var launchers: String?,
    var name: String?,
    var parent: Any?,
    var spacecraft: String?,
    var type: String?,
    var url: String?
)

data class Status(
    var id: Int?,
    var name: String?
)

data class Type(
    var id: Int?,
    var name: String?
)

data class Flight(
    var failreason: String?,
    var hashtag: Any?,
    var holdreason: String?,
    var id: String?,
    var image: String?,
    var infographic: Any?,
    var inhold: Boolean?,
    var launch_library_id: Int?,
    var launch_service_provider: LaunchServiceProvider?,
    var mission: Mission?,
    var name: String?,
    var net: String?,
    var pad: Pad?,
    var probability: Int?,
    var rocket: Rocket?,
    var slug: String?,
    var status: Status?,
    var tbddate: Boolean?,
    var tbdtime: Boolean?,
    var url: String?,
    var window_end: String?,
    var window_start: String?
)

data class Landing(
    var destination: String?,
    var id: Int?,
    var launch: Launch?,
    var mission_end: String?,
    var spacecraft: Spacecraft?,
    var url: String?
)



data class LaunchServiceProvider(
    var id: Int?,
    var name: String?,
    var type: String?,
    var url: String?
)

data class Mission(
    var description: String?,
    var id: Int?,
    var launch_library_id: Int?,
    var name: String?,
    var orbit: String?,
    var orbit_abbrev: String?,
    var type: String?
)

data class Pad(
    var agency_id: Int?,
    var id: Int?,
    var info_url: Any?,
    var latitude: String?,
    var location: Location?,
    var longitude: String?,
    var map_image: String?,
    var map_url: String?,
    var name: String?,
    var total_launch_count: Int?,
    var wiki_url: String?
)

data class Rocket(
    var configuration: Configuration?,
    var id: Int?
)

data class Location(
    var country_code: String?,
    var id: Int?,
    var map_image: String?,
    var name: String?,
    var total_landing_count: Int?,
    var total_launch_count: Int?
)

data class Configuration(
    var family: String?,
    var full_name: String?,
    var id: Int?,
    var launch_library_id: Int?,
    var name: String?,
    var url: String?,
    var variant: String?
)

data class Launch(
    var failreason: String?,
    var hashtag: Any?,
    var holdreason: String?,
    var id: String?,
    var image: String?,
    var infographic: Any?,
    var inhold: Boolean?,
    var launch_library_id: Int?,
    var launch_service_provider: LaunchServiceProvider?,
    var mission: Mission?,
    var name: String?,
    var net: String?,
    var pad: Pad?,
    var probability: Int?,
    var rocket: Rocket?,
    var slug: String?,
    var status: Status?,
    var tbddate: Boolean?,
    var tbdtime: Boolean?,
    var url: String?,
    var window_end: String?,
    var window_start: String?
)

data class Spacecraft(
    var configuration: Configuration?,
    var description: String?,
    var id: Int?,
    var name: String?,
    var serial_number: String?,
    var status: Status?,
    var url: String?
)