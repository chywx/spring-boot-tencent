package cn.chendahai.controller.at;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/3/16 0016
 */
@Data
public class AfricastalkingVoice {

    /**
     * isActive
     * String	This variable lets your application know whether the call is in session state. The API will set a value of 0 in the final request to your application.
     * sessionId
     * String	This is a unique identifier that we will generate during each call session. This variable will stay the same throughout the call
     * direction
     * String	Whether this is an inbound or outbound call. Inbound calls are initiated by a phone user while outbound calls are initiated by your application.
     * destinationNumber
     * String	destinationNumber is Your Africa’s Talking phone number. This will also be presented in international format, starting with a +.
     * callerNumber
     * String	The phone number of the phone user in the call. The phone numbers are all in international format, starting with a + (such as +254711XXXYYY)
     * callerCountryCode
     * String	The code of the country the callerNumber is calling from.
     * callStartTime
     * String	The time the call began.
     * dtmfDigits
     * String	This variable contains the digits that a user enters in response to a getDigits request. Only present in a notification following a GetDigits response.
     * recordingUrl
     * String	The URL of the recording made for this call (using either the Record element, or the record attribute of the Dial element). Only present in the notification following a partial recording, or in the final notification if it is a terminal recording.
     * durationInSeconds
     * String	The duration of the call in seconds. Only present in the final notification.
     * currencyCode
     * String	The currency used to bill this call (e.g KES, USD, GBP). Only present in the final notification.
     * amount
     * String	The total cost of the call. Only present in the final notification.
     * callSessionState
     * String	The final status of the call. Only present in the final notification.
     * dialDestinationNumber
     * String	The number which a call was forwarded to if the Dial action was used. Only present in the final notification.
     * dialDurationInSeconds
     * String	The duration of the dialed call if the Dial action was used. Only present in the final notification.
     * dialStartTime
     * String	The time the dial action began if the Dial action was used. Only present in the final notification.
     */

    /**
     * destinationNumber : +254711082130
     * direction : Outbound
     * status : Success
     * sessionId : ATVId_aadedf81fb9437cabae902bb08d32b7b
     * durationInSeconds : 7
     * callSessionState : Completed
     * callerCarrierName : Safaricom
     * amount : 0.408333333333333345
     * callStartTime : 2020-03-16+05:12:57
     * callerNumber : +254794263043
     * callerCountryCode : 254
     * isActive : 0
     * currencyCode : KES
     */
    private String isActive;
    private String sessionId;
    private String direction;
    private String destinationNumber;
    private String callerCarrierName;
    private String callerCountryCode;
    private String callStartTime;
    private String dtmfDigits;
    private String recordingUrl;
    private String durationInSeconds;
    private String currencyCode;
    private String amount;
    private String callSessionState;
    private String dialDestinationNumber;
    private String dialDurationInSeconds;
    private String dialStartTime;
    private String hangupCause;

    private String status;
    private String callerNumber;

    public String getCallerNumber() {
        if (StringUtils.isEmpty(callerNumber)) {
            return callerNumber;
        }
        return callerNumber.startsWith("+") ? callerNumber.substring(1) : callerNumber;
    }

}
