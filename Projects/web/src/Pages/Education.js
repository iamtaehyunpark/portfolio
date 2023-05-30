import React, { useState, useEffect } from 'react';
import Nav from '../Component/Navbar';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';


function Community(props){
    const location = useLocation();
    const navigate = useNavigate();

    const [comLst, setComLst] = useState([]);
    const [medLst, setMedLst] = useState([]);
    const [traLst, setTraLst] = useState([]);

    const title = ["Is dying your dog’s fur actually that bad?","Your dog may be begging for a wellness routine","Hair of the Dog: The Rise of Luxe Pet Grooming Products"];
    useEffect(() => {
        var cLst=[];
        var mLst=[];
        var tLst=[];

        axios({
            method: 'GET',
            url: 'http://localhost:80/board',
        }).then((data)=>{
            var datas = data.data
            var list;
            for(var i =0; i<datas.length;i++){
                if(datas[i].category === 'common-sense'){
                    cLst.push(datas[i])
                }
                else if(datas[i].category === "health"){
                    mLst.push(datas[i])
                }
                else if(datas[i].category === "train"){
                    tLst.push(datas[i])
                }
            }

            list = cLst.map(num => (
                <div className='common-sense'>
                    <p className='common-sense-title'>{num.title}</p>
                    <p className='common-sense-content'>{num.contents} </p>
                </div>
            ));
            setComLst(list);

            list = mLst.map(num => (
                <div className='Health'>
                    <p className='Health-title'>{num.title}</p>
                    <p className='Health-content'>{num.contents} </p>
                </div>
            ));
            setMedLst(list);

            list = tLst.map(num => (
                <div className='Train'>
                    <p className='Train-title'>{num.title}</p>
                    <p className='Train-content' dangerouslySetInnerHTML={{ __html: num.contents }} />
                </div>
            ));
            setTraLst(list);
        })
    }, [])
    
    const gotoinfo1 = () =>{
        navigate('/Community',{state:{user:true}});
    }
    const gotoinfoBo = () =>{
        navigate('/Bo',{state:{user:true}});
    }
    const gotoinfoAu = () =>{
        navigate('/Au',{state:{user:true}});
    }
    const gotoinfoBi = () =>{
        navigate('/Bi',{state:{user:true}});
    }
    const gotoinfoBu = () =>{
        navigate('/Bu',{state:{user:true}});
    }
    const gotoinfoDa = () =>{
        navigate('/Da',{state:{user:true}});
    }
    const gotoinfoDo = () =>{
        navigate('/Do',{state:{user:true}});
    }
    const gotoinfoPu = () =>{
        navigate('/Pu',{state:{user:true}});
    }
    const gotoinfoSa = () =>{
        navigate('/Sa',{state:{user:true}});
    }
    const gotoinfoSh = () =>{
        navigate('/Sh',{state:{user:true}});
    }
    const gotoinfoWe = () =>{
        navigate('/We',{state:{user:true}});
    }
     const gotoinfoYo = () =>{
        navigate('/Yo',{state:{user:true}});
    }
    return(
        <div className='education-background'>
            <Nav profile={props.profile} setProfile = {props.setProfile}></Nav>
                <div className='blog'>
                    <div className='info1' onClick={gotoinfo1}>
                        <p className='info1_title'>{title[0]}</p>
                    </div>
                    <div className='info2' onClick={gotoinfo1}>
                        <p className='info2_title'>{title[1]}</p>
                    </div>
                    <div className='info3' onClick={gotoinfo1}>
                        <p className='info3_title'>{title[2]}</p>
                    </div>
                </div>
                    
                <div className='main'>
                    <input type="radio" id="tab-1" name="show" />
                    <input type="radio" id="tab-2" name="show" />
                    <input type="radio" id="tab-3" name="show" />
                    <input type="radio" id="tab-4" name="show" />
                    <input type="radio" id="tab-5" name="show" />
                    <div class="tab">
                        <label for="tab-1">Breeds</label>
                        <label for="tab-2">Common Sense</label>
                        <label for="tab-3">Medical</label>
                        <label for="tab-4">Training</label>
                    </div>
                    <div class="content">
                    <div class="content-dis">
                        
                        <div className='DogImg' onClick={gotoinfoAu}>
                            <img className='DogImg' src='Au.webp' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>Australian Cattle Dog</p>
                        </div>
                        <div className='DogImg' onClick={gotoinfoBi}>
                            <img className='DogImg' src='Bi.jpeg' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>Bichon Frise</p>
                        </div>
                        <div className='DogImg' onClick={gotoinfoBu}>
                            <img className='DogImg' src='Bu.jpeg' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>Bulldog</p>
                        </div>
                        <div className='DogImg' onClick={gotoinfoDa}>
                            <img className='DogImg' src='Da.jpeg' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>Dachshund</p>
                        </div>
                        <div className='DogImg' onClick={gotoinfoDo}>
                            <img className='DogImg' src='Do.jpeg' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>Dobermann</p>
                        </div>
                        <div className='DogImg' onClick={gotoinfoPu}>
                            <img className='DogImg' src='Pu.jpeg' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>Puli</p>
                        </div>
                        <div className='DogImg' onClick={gotoinfoYo}>
                            <img className='DogImg' src='Yo.webp' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>Yorkshire Terrier</p>
                        </div>
                        <div className='DogImg' onClick={gotoinfoSa}>
                            <img className='DogImg' src='Sa.webp' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>Samoyed</p>
                        </div>
                        <div className='DogImg' onClick={gotoinfoSh}>
                            <img className='DogImg' src='Sh.jpeg' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>Shiba</p>
                        </div>
                        <div className='DogImg' onClick={gotoinfoWe}>
                            <img className='DogImg' src='We.jpeg' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>Welsh Corgi Cardigan</p>
                        </div>
                        <div className='DogImg' onClick={gotoinfoBo}>
                            <img className='DogImg' src='Border-Collie.webp' alt='Border-Collie'></img>
                            <p className='BORDER_COLLIEInfo'>BORDER COLLIE</p>
                        </div>
                    </div>
                    <div class="content-dis">
                        {comLst}
                    </div>
                    <div class="content-dis">
                        {medLst}
                    </div>
                    <div class="content-dis">
                        {traLst}
                    </div>
                </div>
                </div>
        </div>
    )
}
export default Community;