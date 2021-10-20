import React from "react";
import { GoogleMap, LoadScript, Marker } from "@react-google-maps/api";
import './Map.css'

const containerStyle = {
  width: "85vh",
  height: "85vh"
};

const center = {
  lat: 0,
  lng: 0
};

const locations = [
  {
    lat: 0,
    lng: 0
  },
  {
    lat: 1,
    lng: 1
  }
];

const API_KEY = process.env.REACT_APP_GOOGLE_API_KEY;

const Map = ({onClick}) => {
  return (
    <div className='wrap'>
      <LoadScript googleMapsApiKey={API_KEY}>
        <GoogleMap mapContainerStyle={containerStyle} center={center} zoom={2}>
          {/* Child components, such as markers, info windows, etc. */}
		  {locations.map((location, i) => {
			  return <Marker key={i} position={location} clickable="true" onClick={onClick(location.lat, location.lng)}></Marker>
		  })}
          
        </GoogleMap>
      </LoadScript>
    </div>
  );
};

export default Map;
