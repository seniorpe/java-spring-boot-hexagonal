import { HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

import { CustomHttpResponse } from './custom-http-response';

export type HttpResp<T> = CustomHttpResponse<T>;
export type ObsResp<T> = Observable<HttpResp<T>>;
export type ObsEventResp<T> = Observable<HttpEvent<T>>;
