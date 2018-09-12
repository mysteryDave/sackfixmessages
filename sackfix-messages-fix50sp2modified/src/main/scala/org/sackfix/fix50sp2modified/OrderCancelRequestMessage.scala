package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class OrderCancelRequestMessage(origClOrdIDField:Option[OrigClOrdIDField]=None,
                                     orderIDField:Option[OrderIDField]=None,
                                     clOrdIDField:ClOrdIDField,
                                     secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                                     clOrdLinkIDField:Option[ClOrdLinkIDField]=None,
                                     listIDField:Option[ListIDField]=None,
                                     origOrdModTimeField:Option[OrigOrdModTimeField]=None,
                                     accountField:Option[AccountField]=None,
                                     acctIDSourceField:Option[AcctIDSourceField]=None,
                                     accountTypeField:Option[AccountTypeField]=None,
                                     partiesComponent:Option[PartiesComponent]=None,
                                     instrumentComponent:InstrumentComponent,
                                     financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                     undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                     sideField:SideField,
                                     transactTimeField:TransactTimeField,
                                     orderQtyDataComponent:OrderQtyDataComponent,
                                     complianceIDField:Option[ComplianceIDField]=None,
                                     textField:Option[TextField]=None,
                                     encodedTextLenField:Option[EncodedTextLenField]=None,
                                     encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("F")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    origClOrdIDField.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    fmt(b,clOrdIDField)
    secondaryClOrdIDField.foreach(fmt(b,_))
    clOrdLinkIDField.foreach(fmt(b,_))
    listIDField.foreach(fmt(b,_))
    origOrdModTimeField.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    financingDetailsComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    fmt(b,sideField)
    fmt(b,transactTimeField)
    fmt(b,orderQtyDataComponent)
    complianceIDField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object OrderCancelRequestMessage extends SfFixMessageDecoder {
  val MsgType="F"
  val MsgName="OrderCancelRequest"
             
  override val MandatoryFields = HashSet[Int](
    ClOrdIDField.TagId, SideField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || 
    OrderQtyDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrigClOrdIDField.TagId, OrderIDField.TagId, SecondaryClOrdIDField.TagId, ClOrdLinkIDField.TagId, ListIDField.TagId, 
    OrigOrdModTimeField.TagId, AccountField.TagId, AcctIDSourceField.TagId, AccountTypeField.TagId, ComplianceIDField.TagId, 
    TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || 
    OrderQtyDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId) || OrderQtyDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrigClOrdIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(OrderCancelRequestMessage(myFields.get(OrigClOrdIDField.TagId).flatMap(f=>OrigClOrdIDField.decode(f)),
        myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        ClOrdIDField.decode(myFields.get(ClOrdIDField.TagId)).get,
        myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
        myFields.get(ClOrdLinkIDField.TagId).flatMap(f=>ClOrdLinkIDField.decode(f)),
        myFields.get(ListIDField.TagId).flatMap(f=>ListIDField.decode(f)),
        myFields.get(OrigOrdModTimeField.TagId).flatMap(f=>OrigOrdModTimeField.decode(f)),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        InstrumentComponent.decode(flds, startPos).get,
        FinancingDetailsComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        SideField.decode(myFields.get(SideField.TagId)).get,
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        OrderQtyDataComponent.decode(flds, startPos).get,
        myFields.get(ComplianceIDField.TagId).flatMap(f=>ComplianceIDField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     