import React from 'react';
import { useLocation } from 'react-router-dom';
import Nav from '../Component/Navbar';
import { Swiper, SwiperSlide } from "swiper/react";
// Import Swiper styles
import "swiper/css";
import "swiper/css/effect-fade";
import "swiper/css/navigation";
import "swiper/css/pagination";
// import required modules
import { Autoplay, EffectFade, Navigation, Pagination } from "swiper";

function Main(props){
    const location = useLocation();
    {/*Main page sliding images*/}
    const items = [ 
        { src: "dog.jpeg" },
        { src: "dog1.jpeg" },
        { src: "dog2.jpeg" },
      ];
    return(
        <div>
            <Nav profile={props.profile} setProfile = {props.setProfile}/>{/*Narbar Component*/}
    <>
      <Swiper
        effect={"fade"}
        autoplay={{
          delay: 3000,
          disableOnInteraction: false,
        }}
        pagination={{
          clickable: true,
        }}
        modules={[Navigation, EffectFade, Pagination,Autoplay]}
        className="mySwiper"
        loop={true}
      >
        {items.map((item, idx) => {
          return (
            <SwiperSlide key={idx}>
             <div>
             <img className = "image"src={item.src}/>
             <p className='c'>The smartest way to train your furry best friend</p>
             </div>
           </SwiperSlide>
          );
        })}
      </Swiper>
    </>
    </div>
        )
    }
export default Main;