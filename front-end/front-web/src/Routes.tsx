import {BrowserRouter, Route, Switch} from 'react-router-dom';
import Home from './Home'
import CadastroPessoa from './CadastroPessoa';
import React from 'react';
function Rountes(){
    return(
        
        <BrowserRouter>
            <Switch>
            <Route path="/cadastroPessoa">
                    <CadastroPessoa/>
                </Route>   
                <Route path="/">
                    <Home/>
                </Route>   
            </Switch>
        </BrowserRouter>  
    )
}

export default Rountes;