package org.sackfix.fix50sp2

import org.sackfix.common.validated.fields.SfFixMessageDecoder

/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
object SfMessageFactory {
  def getMessage(msgType:String):Option[SfFixMessageDecoder] = msgType match {
    case "6" => Some(IOIMessage)
    case "7" => Some(AdvertisementMessage)
    case "8" => Some(ExecutionReportMessage)
    case "9" => Some(OrderCancelRejectMessage)
    case "AA" => Some(DerivativeSecurityListMessage)
    case "AB" => Some(NewOrderMultilegMessage)
    case "AC" => Some(MultilegOrderCancelReplaceMessage)
    case "AD" => Some(TradeCaptureReportRequestMessage)
    case "AE" => Some(TradeCaptureReportMessage)
    case "AF" => Some(OrderMassStatusRequestMessage)
    case "AG" => Some(QuoteRequestRejectMessage)
    case "AH" => Some(RFQRequestMessage)
    case "AI" => Some(QuoteStatusReportMessage)
    case "AJ" => Some(QuoteResponseMessage)
    case "AK" => Some(ConfirmationMessage)
    case "AL" => Some(PositionMaintenanceRequestMessage)
    case "AM" => Some(PositionMaintenanceReportMessage)
    case "AN" => Some(RequestForPositionsMessage)
    case "AO" => Some(RequestForPositionsAckMessage)
    case "AP" => Some(PositionReportMessage)
    case "AQ" => Some(TradeCaptureReportRequestAckMessage)
    case "AR" => Some(TradeCaptureReportAckMessage)
    case "AS" => Some(AllocationReportMessage)
    case "AT" => Some(AllocationReportAckMessage)
    case "AU" => Some(ConfirmationAckMessage)
    case "AV" => Some(SettlementInstructionRequestMessage)
    case "AW" => Some(AssignmentReportMessage)
    case "AX" => Some(CollateralRequestMessage)
    case "AY" => Some(CollateralAssignmentMessage)
    case "AZ" => Some(CollateralResponseMessage)
    case "B" => Some(NewsMessage)
    case "BA" => Some(CollateralReportMessage)
    case "BB" => Some(CollateralInquiryMessage)
    case "BC" => Some(NetworkCounterpartySystemStatusRequestMessage)
    case "BD" => Some(NetworkCounterpartySystemStatusResponseMessage)
    case "BE" => Some(UserRequestMessage)
    case "BF" => Some(UserResponseMessage)
    case "BG" => Some(CollateralInquiryAckMessage)
    case "BH" => Some(ConfirmationRequestMessage)
    case "BI" => Some(TradingSessionListRequestMessage)
    case "BJ" => Some(TradingSessionListMessage)
    case "BK" => Some(SecurityListUpdateReportMessage)
    case "BL" => Some(AdjustedPositionReportMessage)
    case "BM" => Some(AllocationInstructionAlertMessage)
    case "BN" => Some(ExecutionAcknowledgementMessage)
    case "BO" => Some(ContraryIntentionReportMessage)
    case "BP" => Some(SecurityDefinitionUpdateReportMessage)
    case "BQ" => Some(SettlementObligationReportMessage)
    case "BR" => Some(DerivativeSecurityListUpdateReportMessage)
    case "BS" => Some(TradingSessionListUpdateReportMessage)
    case "BT" => Some(MarketDefinitionRequestMessage)
    case "BU" => Some(MarketDefinitionMessage)
    case "BV" => Some(MarketDefinitionUpdateReportMessage)
    case "BW" => Some(ApplicationMessageRequestMessage)
    case "BX" => Some(ApplicationMessageRequestAckMessage)
    case "BY" => Some(ApplicationMessageReportMessage)
    case "BZ" => Some(OrderMassActionReportMessage)
    case "C" => Some(EmailMessage)
    case "CA" => Some(OrderMassActionRequestMessage)
    case "CB" => Some(UserNotificationMessage)
    case "CC" => Some(StreamAssignmentRequestMessage)
    case "CD" => Some(StreamAssignmentReportMessage)
    case "CE" => Some(StreamAssignmentReportACKMessage)
    case "D" => Some(NewOrderSingleMessage)
    case "E" => Some(NewOrderListMessage)
    case "F" => Some(OrderCancelRequestMessage)
    case "G" => Some(OrderCancelReplaceRequestMessage)
    case "H" => Some(OrderStatusRequestMessage)
    case "J" => Some(AllocationInstructionMessage)
    case "K" => Some(ListCancelRequestMessage)
    case "L" => Some(ListExecuteMessage)
    case "M" => Some(ListStatusRequestMessage)
    case "N" => Some(ListStatusMessage)
    case "P" => Some(AllocationInstructionAckMessage)
    case "Q" => Some(DontKnowTradeMessage)
    case "R" => Some(QuoteRequestMessage)
    case "S" => Some(QuoteMessage)
    case "T" => Some(SettlementInstructionsMessage)
    case "V" => Some(MarketDataRequestMessage)
    case "W" => Some(MarketDataSnapshotFullRefreshMessage)
    case "X" => Some(MarketDataIncrementalRefreshMessage)
    case "Y" => Some(MarketDataRequestRejectMessage)
    case "Z" => Some(QuoteCancelMessage)
    case "a" => Some(QuoteStatusRequestMessage)
    case "b" => Some(MassQuoteAcknowledgementMessage)
    case "c" => Some(SecurityDefinitionRequestMessage)
    case "d" => Some(SecurityDefinitionMessage)
    case "e" => Some(SecurityStatusRequestMessage)
    case "f" => Some(SecurityStatusMessage)
    case "g" => Some(TradingSessionStatusRequestMessage)
    case "h" => Some(TradingSessionStatusMessage)
    case "i" => Some(MassQuoteMessage)
    case "j" => Some(BusinessMessageRejectMessage)
    case "k" => Some(BidRequestMessage)
    case "l" => Some(BidResponseMessage)
    case "m" => Some(ListStrikePriceMessage)
    case "o" => Some(RegistrationInstructionsMessage)
    case "p" => Some(RegistrationInstructionsResponseMessage)
    case "q" => Some(OrderMassCancelRequestMessage)
    case "r" => Some(OrderMassCancelReportMessage)
    case "s" => Some(NewOrderCrossMessage)
    case "t" => Some(CrossOrderCancelReplaceRequestMessage)
    case "u" => Some(CrossOrderCancelRequestMessage)
    case "v" => Some(SecurityTypeRequestMessage)
    case "w" => Some(SecurityTypesMessage)
    case "x" => Some(SecurityListRequestMessage)
    case "y" => Some(SecurityListMessage)
    case "z" => Some(DerivativeSecurityListRequestMessage)
    case _ => None
  }
}
