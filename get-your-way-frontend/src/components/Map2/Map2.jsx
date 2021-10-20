import React from 'react'
import GoogleMapReact from 'google-map-react'
import mapStyles from './mapStyles'

const mapContainer = {
	height: '100vh',
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

const locations = [
	{
		lat: 51.5072,
		lng: 0.1276,
	},
	{
		lat: 40.7128,
		lng: 74.006,
	},
]

const API_KEY = process.env.REACT_APP_GOOGLE_API_KEY

const AnyReactComponent = ({ text }) => <div>{text}</div>

const Map2 = () => {
	return (
		<div style={mapContainer}>
			<GoogleMapReact
				bootstrapURLKeys={{key: API_KEY}}
				defaultCenter={center}
				center={center}
				defaultZoom={14}
				margin={[50, 50, 50, 50]}
				options={{ disableDefaultUI: true, zoomControl: true, styles: mapStyles }}>
				<AnyReactComponent lat={59.955413} lng={30.337844} text='My Marker' />
			</GoogleMapReact>
		</div>
	)
}

export default Map2
