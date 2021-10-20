import React from 'react'
import GoogleMapReact from 'google-map-react'
import LocationOnOutlinedIcon from '@material-ui/icons/LocationOnOutlined'
import mapStyles from './mapStyles'

const mapContainer = {
	height: '85vh',
	width: '100%',
}

const markerContainer = {
	position: 'absolute',
	transform: 'translate(-50%, -50%)',
	zIndex: 1,
}

const center = {
	lat: 51.5072,
	lng: 0.1276,
}

const API_KEY = process.env.REACT_APP_GOOGLE_API_KEY

const Map2 = ({ locations, setChosenLocation }) => {
	return (
		<div style={mapContainer}>
			<GoogleMapReact
				bootstrapURLKeys={{ key: API_KEY }}
				defaultCenter={center}
				center={locations[0]}
				defaultZoom={14}
				margin={[50, 50, 50, 50]}
				options={{
					disableDefaultUI: true,
					zoomControl: true,
					styles: mapStyles,
				}}
				onChildClick={(child) => setChosenLocation(locations[child])}
			>
				{locations?.map((location, i) => (
					<div
						style={markerContainer}
						lat={location.lat}
						lng={location.lng}
						key={i}
					>
						<LocationOnOutlinedIcon
							color='secondary'
							fontSize='large'
						/>
					</div>
				))}
			</GoogleMapReact>
		</div>
	)
}

export default Map2
