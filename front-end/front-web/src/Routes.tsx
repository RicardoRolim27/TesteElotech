import {BrowserRouter, Route, Switch} from 'react-router-dom';
import Home from './Home'
function Rountes(){
    return(
        
        <BrowserRouter>
            <Switch>
                <Route path="/">
                    <Home/>
                </Route>   
            </Switch>
        </BrowserRouter>  
    )
}

export default Rountes;