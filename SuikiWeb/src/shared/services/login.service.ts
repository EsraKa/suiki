import { Injectable } from '@angular/core';
import {RequestOptions, Headers, Http, Response} from "@angular/http";
import {Observable} from "rxjs";

@Injectable()
export class LoginService {

  constructor(private http: Http) { }

  login(credentials) {
    let body = JSON.stringify({ credentials });
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });

    return this.http.post('/login', body, options)
      .do(data => console.log(data.json())) // eyeball results in the console
      .map(res => res.json())
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    // in a real world app, we may send the error to some remote logging infrastructure
    // instead of just logging it to the console
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }

}
