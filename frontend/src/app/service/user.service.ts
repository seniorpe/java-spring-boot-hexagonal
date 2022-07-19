import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { CrudService } from './crud.service';

import { environment } from 'src/environments/environment';
import { ObsResp, HttpResp } from './interface/response.utils';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserService extends CrudService<User, null> {
    private readonly _host = environment.URL_API;
    private readonly _endPoint;

    constructor(protected readonly http: HttpClient) {
        super(http, 'users');
        this._endPoint = `${this._host}/${this.endpoint}`;
    }

    readAll(page: number, size: number, sort: string): Observable<any> {
        return this.http.get<any>(
            `${this._endPoint}?page=${page}&size=${size}&sort=${sort}`
        );
    }
}
