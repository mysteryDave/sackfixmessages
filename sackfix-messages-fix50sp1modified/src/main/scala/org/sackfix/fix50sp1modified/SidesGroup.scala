package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class SidesGroup(sideField:SideField,
                      origClOrdIDField:Option[OrigClOrdIDField]=None,
                      clOrdIDField:ClOrdIDField,
                      secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                      clOrdLinkIDField:Option[ClOrdLinkIDField]=None,
                      partiesComponent:Option[PartiesComponent]=None,
                      tradeOriginationDateField:Option[TradeOriginationDateField]=None,
                      tradeDateField:Option[TradeDateField]=None,
                      accountField:Option[AccountField]=None,
                      acctIDSourceField:Option[AcctIDSourceField]=None,
                      accountTypeField:Option[AccountTypeField]=None,
                      dayBookingInstField:Option[DayBookingInstField]=None,
                      bookingUnitField:Option[BookingUnitField]=None,
                      preallocMethodField:Option[PreallocMethodField]=None,
                      allocIDField:Option[AllocIDField]=None,
                      preAllocGrpComponent:Option[PreAllocGrpComponent]=None,
                      qtyTypeField:Option[QtyTypeField]=None,
                      orderQtyDataComponent:OrderQtyDataComponent,
                      commissionDataComponent:Option[CommissionDataComponent]=None,
                      orderCapacityField:Option[OrderCapacityField]=None,
                      orderRestrictionsField:Option[OrderRestrictionsField]=None,
                      preTradeAnonymityField:Option[PreTradeAnonymityField]=None,
                      custOrderCapacityField:Option[CustOrderCapacityField]=None,
                      forexReqField:Option[ForexReqField]=None,
                      settlCurrencyField:Option[SettlCurrencyField]=None,
                      bookingTypeField:Option[BookingTypeField]=None,
                      textField:Option[TextField]=None,
                      encodedTextLenField:Option[EncodedTextLenField]=None,
                      encodedTextField:Option[EncodedTextField]=None,
                      positionEffectField:Option[PositionEffectField]=None,
                      coveredOrUncoveredField:Option[CoveredOrUncoveredField]=None,
                      cashMarginField:Option[CashMarginField]=None,
                      clearingFeeIndicatorField:Option[ClearingFeeIndicatorField]=None,
                      solicitedFlagField:Option[SolicitedFlagField]=None,
                      sideComplianceIDField:Option[SideComplianceIDField]=None,
                      sideTimeInForceField:Option[SideTimeInForceField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,sideField)
    origClOrdIDField.foreach(fmt(b,_))
    fmt(b,clOrdIDField)
    secondaryClOrdIDField.foreach(fmt(b,_))
    clOrdLinkIDField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    tradeOriginationDateField.foreach(fmt(b,_))
    tradeDateField.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    dayBookingInstField.foreach(fmt(b,_))
    bookingUnitField.foreach(fmt(b,_))
    preallocMethodField.foreach(fmt(b,_))
    allocIDField.foreach(fmt(b,_))
    preAllocGrpComponent.foreach(fmt(b,_))
    qtyTypeField.foreach(fmt(b,_))
    fmt(b,orderQtyDataComponent)
    commissionDataComponent.foreach(fmt(b,_))
    orderCapacityField.foreach(fmt(b,_))
    orderRestrictionsField.foreach(fmt(b,_))
    preTradeAnonymityField.foreach(fmt(b,_))
    custOrderCapacityField.foreach(fmt(b,_))
    forexReqField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    bookingTypeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    positionEffectField.foreach(fmt(b,_))
    coveredOrUncoveredField.foreach(fmt(b,_))
    cashMarginField.foreach(fmt(b,_))
    clearingFeeIndicatorField.foreach(fmt(b,_))
    solicitedFlagField.foreach(fmt(b,_))
    sideComplianceIDField.foreach(fmt(b,_))
    sideTimeInForceField.foreach(fmt(b,_))
    b
  }

}
     
object SidesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int](
    SideField.TagId, ClOrdIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || PreAllocGrpComponent.isMandatoryField(tagId) || OrderQtyDataComponent.isMandatoryField(tagId) || CommissionDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrigClOrdIDField.TagId, SecondaryClOrdIDField.TagId, ClOrdLinkIDField.TagId, TradeOriginationDateField.TagId, TradeDateField.TagId, 
    AccountField.TagId, AcctIDSourceField.TagId, AccountTypeField.TagId, DayBookingInstField.TagId, BookingUnitField.TagId, 
    PreallocMethodField.TagId, AllocIDField.TagId, QtyTypeField.TagId, OrderCapacityField.TagId, OrderRestrictionsField.TagId, 
    PreTradeAnonymityField.TagId, CustOrderCapacityField.TagId, ForexReqField.TagId, SettlCurrencyField.TagId, BookingTypeField.TagId, 
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, PositionEffectField.TagId, CoveredOrUncoveredField.TagId, 
    CashMarginField.TagId, ClearingFeeIndicatorField.TagId, SolicitedFlagField.TagId, SideComplianceIDField.TagId, SideTimeInForceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || PreAllocGrpComponent.isOptionalField(tagId) || OrderQtyDataComponent.isOptionalField(tagId) || CommissionDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || PreAllocGrpComponent.isFieldOf(tagId) || OrderQtyDataComponent.isFieldOf(tagId) || 
    CommissionDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SideField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[SidesGroup]=ArrayBuffer.empty[SidesGroup]):Option[List[SidesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[SidesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[SidesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(SidesGroup(SideField.decode(myFields.get(SideField.TagId)).get,
          myFields.get(OrigClOrdIDField.TagId).flatMap(f=>OrigClOrdIDField.decode(f)),
          ClOrdIDField.decode(myFields.get(ClOrdIDField.TagId)).get,
          myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
          myFields.get(ClOrdLinkIDField.TagId).flatMap(f=>ClOrdLinkIDField.decode(f)),
          PartiesComponent.decode(flds, startPos),
          myFields.get(TradeOriginationDateField.TagId).flatMap(f=>TradeOriginationDateField.decode(f)),
          myFields.get(TradeDateField.TagId).flatMap(f=>TradeDateField.decode(f)),
          myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
          myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
          myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
          myFields.get(DayBookingInstField.TagId).flatMap(f=>DayBookingInstField.decode(f)),
          myFields.get(BookingUnitField.TagId).flatMap(f=>BookingUnitField.decode(f)),
          myFields.get(PreallocMethodField.TagId).flatMap(f=>PreallocMethodField.decode(f)),
          myFields.get(AllocIDField.TagId).flatMap(f=>AllocIDField.decode(f)),
          PreAllocGrpComponent.decode(flds, startPos),
          myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
          OrderQtyDataComponent.decode(flds, startPos).get,
          CommissionDataComponent.decode(flds, startPos),
          myFields.get(OrderCapacityField.TagId).flatMap(f=>OrderCapacityField.decode(f)),
          myFields.get(OrderRestrictionsField.TagId).flatMap(f=>OrderRestrictionsField.decode(f)),
          myFields.get(PreTradeAnonymityField.TagId).flatMap(f=>PreTradeAnonymityField.decode(f)),
          myFields.get(CustOrderCapacityField.TagId).flatMap(f=>CustOrderCapacityField.decode(f)),
          myFields.get(ForexReqField.TagId).flatMap(f=>ForexReqField.decode(f)),
          myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f)),
          myFields.get(BookingTypeField.TagId).flatMap(f=>BookingTypeField.decode(f)),
          myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
          myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
          myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
          myFields.get(PositionEffectField.TagId).flatMap(f=>PositionEffectField.decode(f)),
          myFields.get(CoveredOrUncoveredField.TagId).flatMap(f=>CoveredOrUncoveredField.decode(f)),
          myFields.get(CashMarginField.TagId).flatMap(f=>CashMarginField.decode(f)),
          myFields.get(ClearingFeeIndicatorField.TagId).flatMap(f=>ClearingFeeIndicatorField.decode(f)),
          myFields.get(SolicitedFlagField.TagId).flatMap(f=>SolicitedFlagField.decode(f)),
          myFields.get(SideComplianceIDField.TagId).flatMap(f=>SideComplianceIDField.decode(f)),
          myFields.get(SideTimeInForceField.TagId).flatMap(f=>SideTimeInForceField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     