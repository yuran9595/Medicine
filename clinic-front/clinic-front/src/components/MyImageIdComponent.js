import React, { useState, useEffect } from 'react';

function MyImageIdConponent(props) {

    const [image, setImage] = useState();
    const PATH = "http://localhost:8082/api/v1/public/image/"+props.imageId;

    useEffect(() => {
        fetch(PATH)
            .then(res => res.blob())
            .then(blob => {
                const reader = new FileReader();
                reader.readAsDataURL(blob);
                reader.onloadend = () => setImage(reader.result)
          });
      }, []);
    

    return (
        <img src={image} alt='image' width={280} height={250}/>
    );
}

export default MyImageIdConponent;